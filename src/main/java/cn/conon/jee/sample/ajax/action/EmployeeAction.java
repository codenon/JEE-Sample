package cn.conon.jee.sample.ajax.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import cn.conon.jee.sample.ajax.dao.DeptDao;
import cn.conon.jee.sample.ajax.dao.LocationDao;
import cn.conon.jee.sample.ajax.domain.Department;
import cn.conon.jee.sample.ajax.domain.Location;

public class EmployeeAction extends DispatchAction {

	private LocationDao locationDao = new LocationDao();
	private DeptDao deptDao = new DeptDao();

	public ActionForward showDepts(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		String locationId = request.getParameter("locationId");
		String sql = "SELECT department_id departmentId, department_name departmentName FROM departments " +
				"WHERE location_id = ?";
		List<Department> depts = deptDao.getForList(sql, locationId);

		StringBuilder result = new StringBuilder("[");

		for (Department dept : depts) {
			int departmentId = dept.getDepartmentId();
			String departmentName = dept.getDepartmentName();

			result.append("{")
					.append("departmentId:").append(departmentId)
					.append(",")
					.append("departmentName:'").append(departmentName).append("'")
					.append("}")
					.append(",");
		}

		if (depts.size() > 0) {
			result.replace(result.length() - 1, result.length(), "");
		}

		result.append("]");

		System.out.println(result.toString());

		response.setContentType("text/javascript");
		response.getWriter().print(result.toString());

		return null;
	}

	public ActionForward showCities(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		String sql = "SELECT location_id locationId, city FROM locations";
		List<Location> locations = locationDao.getForList(sql);
		request.setAttribute("locations", locations);
		return mapping.findForward("success");
	}

}
