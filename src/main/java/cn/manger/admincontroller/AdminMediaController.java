package cn.manger.admincontroller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.manger.model.Tmedia;
import cn.manger.service.Service;

@Controller
public class AdminMediaController {

	// @Resource
	// private MydfsTrackerServer mydfsTrackerServer;
	private static final Log log = LogFactory
			.getLog(AdminMediaController.class);
	@Resource
	private Service service;

	@RequestMapping(value = "/admin/media/list")
	public ModelAndView list() {
		@SuppressWarnings("unchecked")
		List<Tmedia> tmediaList = (List<Tmedia>) service.findList(Tmedia.class);
		ModelAndView modelView = new ModelAndView();
		modelView.addObject("tmediaList", tmediaList);
		String view = "/WEB-INF/back/media/list.jsp";
		modelView.setViewName(view);
		return modelView;
	}

	@RequestMapping("/admin/media/addMediaView")
	public ModelAndView addMediaView() {
		ModelAndView modelView = new ModelAndView();
		String viewName = "/WEB-INF/back/media/add.jsp";
		modelView.setViewName(viewName);
		return modelView;
	}

	// @RequestMapping(value = "/admin/media/addMedia")
	// public String addMedia(HttpServletRequest request, Tmedia media) {
	// MultipartHttpServletRequest multipartRequest =
	// (MultipartHttpServletRequest) request;
	// String storepath = "";
	// Map<String, MultipartFile> files = multipartRequest.getFileMap();
	// for (MultipartFile file : files.values()) {
	// InputStream inputStream;
	// try {
	// inputStream = file.getInputStream();
	// if (inputStream.available() == 0) {
	// break;
	// }
	// Assert.assertNotNull("upload file InputStream is null",
	// inputStream);
	// String originName = file.getOriginalFilename();
	// String extention = originName.substring(originName
	// .lastIndexOf(".") + 1);
	// log.debug("upload file stuffix:" + extention);
	// storepath += mydfsTrackerServer.upload(inputStream, extention);
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// }
	// media.setImgurl(storepath);
	// service.saveorupdate(media);
	// return "redirect:/admin/media/list.jhtml";
	// }

	@RequestMapping("/admin/media/updateMedia")
	public ModelAndView updateMedia(Tmedia media) {
		service.saveorupdate(media);
		ModelAndView modelView = new ModelAndView();
		modelView.setViewName("");
		return modelView;
	}
}
