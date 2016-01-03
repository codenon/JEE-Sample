package cn.conon.jee.sample.struts1.provider.service;

import java.util.List;

import cn.conon.jee.sample.struts1.provider.domain.Video;

public interface VideoService {

	/**
	 * 获取最新的视频资讯
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Video> getLastVideos() throws Exception;

}