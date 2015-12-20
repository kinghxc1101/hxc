package cn.manger.admincontroller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import mydfs.storage.server.MydfsTrackerServer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import cn.manger.model.Tnews;
import cn.manger.service.Service;

@Controller
public class AdminNewsController {

	@Resource
	private MydfsTrackerServer mydfsTrackerServer;
	@SuppressWarnings("unused")
	private static final Log log = LogFactory.getLog(AdminNewsController.class);
	@Resource
	private Service service;

	@RequestMapping(value = "/admin/news/list")
	public ModelAndView list() {
		@SuppressWarnings("unchecked")
		List<Tnews> tnewsList = (List<Tnews>) service.findList(Tnews.class);
		ModelAndView modelView = new ModelAndView();
		modelView.addObject("tnewsList", tnewsList);
		String view = "/WEB-INF/back/news/list.jsp";
		modelView.setViewName(view);
		return modelView;
	}

	@RequestMapping("/admin/news/add")
	public ModelAndView addnewsView() {
		ModelAndView modelView = new ModelAndView();
		String viewName = "/WEB-INF/back/news/add.jsp";
		modelView.setViewName(viewName);
		return modelView;
	}

	@RequestMapping(value = "/admin/news/addnews")
	public String addnews(HttpServletRequest request, Tnews news) {
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		String storepath = "";
		Map<String, MultipartFile> files = multipartRequest.getFileMap();
		for (MultipartFile file : files.values()) {
			InputStream inputStream;
			try {
				inputStream = file.getInputStream();
				if (inputStream.available() == 0) {
					break;
				}
				Assert.assertNotNull("upload file InputStream is null",
						inputStream);
				String originName = file.getOriginalFilename();
				String extention = originName.substring(originName
						.lastIndexOf(".") + 1);
				log.debug("upload file stuffix:" + extention);
				storepath += mydfsTrackerServer.upload(inputStream, extention);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		news.setImgurl(storepath);
		service.saveorupdate(news);
		return "redirect:/admin/news/list.jhtml";
	}

	@RequestMapping("/admin/news/updatenews")
	public ModelAndView updatenews(Tnews news) {
		service.saveorupdate(news);
		ModelAndView modelView = new ModelAndView();
		modelView.setViewName("");
		return modelView;
	}

	@RequestMapping("/admin/news/save")
	public ModelAndView savenews(Tnews news) {
		service.saveorupdate(news);
		ModelAndView modelView = new ModelAndView();
		modelView.setViewName("/WEB-INF/back/news/list.jsp");
		return modelView;
	}
}
