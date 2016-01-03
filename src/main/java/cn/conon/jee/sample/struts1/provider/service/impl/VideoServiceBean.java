package cn.conon.jee.sample.struts1.provider.service.impl;

import java.util.ArrayList;
import java.util.List;

import cn.conon.jee.sample.struts1.provider.domain.Video;
import cn.conon.jee.sample.struts1.provider.service.VideoService;

public class VideoServiceBean implements VideoService {

	public List<Video> getLastVideos() throws Exception {
		List<Video> videos = new ArrayList<Video>();
		videos.add(new Video(23, "喜羊羊与灰太狼全集", 45));
		videos.add(new Video(45, "实拍舰载直升东海救援演习", 90));
		videos.add(new Video(78, "喀麦隆VS荷兰", 20));
		return videos;
	}
}
