package system.controller.dictype;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import system.comm.base.Json;
import system.comm.base.PageBean;
import system.comm.base.TreeEntity;
import system.comm.utils.JSONHelper;
import system.comm.utils.PrimaryKey;
import system.comm.utils.StringUtil;
import system.entity.dictype.DicTypeEntity;
import system.service.dictype.DictypeService;
import utils.pageplugin.Page;

/**
 * 数据字典
 * @author zhouq
 * @create 2014年8月13日 下午1:41:21
 */
@Controller
@RequestMapping("dictypeController")
public class DictypeController {
	
	@Autowired(required=false) 
	private DictypeService<DicTypeEntity> dictypeService; 
	

	
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request){
		return new ModelAndView("jsp/system/dictype/list");
	}	
	
	@RequestMapping(params = "loadDataGrid")
	@ResponseBody
	public Object loadDataGrid(HttpServletRequest request,Page page){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("page", page);
		List<DicTypeEntity> dataList = dictypeService.queryByPList(map);
		PageBean<DicTypeEntity> pageList = new PageBean<DicTypeEntity>(dataList,page);//封装结果集
		return pageList;
	}
	
	@RequestMapping(params = "childList")
	public ModelAndView childList(HttpServletRequest request){
		String pid = request.getParameter("pid");
		request.setAttribute("pid",pid);
		return new ModelAndView("jsp/system/dictype/childList");
	}
	
	@RequestMapping(params = "loadChildDataGrid")
	@ResponseBody
	public Object loadChildDataGrid(HttpServletRequest request,Page page){
		Map<String, Object> map = new HashMap<String, Object>();
		String pid = request.getParameter("pid");
		map.put("pid", pid);
		map.put("page", page);
		List<DicTypeEntity> dataList = dictypeService.queryBylistPage(map);
		PageBean<DicTypeEntity> pageList = new PageBean<DicTypeEntity>(dataList,page);//封装结果集
		return pageList;
	}
	
	/**
	 * 新增页面
	 * @author zhouq
	 * @create 2014年8月13日 下午1:41:38
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "addPage")
	public ModelAndView addPage(String uid, HttpServletRequest request){
		//查询该用户所有的菜单列表
		List<TreeEntity> dictypeTree = new ArrayList<TreeEntity>();	
		dictypeTree = dictypeService.queryAllDictypeList(null);
		
		if (StringUtil.isValid(uid)) {//编辑页面
			//查询字典列表
			DicTypeEntity entity = dictypeService.getEntityByUid(uid);
			request.setAttribute("dictype", entity);
			//查询对应的父字典
			String pid = entity.getPid();
			if (!"0".equals(pid)) {//0：根节点，没有父菜单
				DicTypeEntity pDictype = (DicTypeEntity) dictypeService.queryById(pid);
				List<TreeEntity> rTree =  new ArrayList<TreeEntity>();
				for (TreeEntity tree : dictypeTree) {
					if (tree.getId().equals(pDictype.getId())) {
						tree.setChecked(true);
					}
					rTree.add(tree);
				}
				request.setAttribute("dictypeTree", JSONHelper.collection2json(rTree));
			}else {
				request.setAttribute("dictypeTree", JSONHelper.collection2json(dictypeTree));
			}
		}else {
			request.setAttribute("dictypeTree", JSONHelper.collection2json(dictypeTree));
		}
		return new ModelAndView("jsp/system/dictype/add");
	}
	
	/**
	 * 保存方法
	 * @author zhouq
	 * @create 2014年8月13日 下午1:41:47
	 * @param request
	 * @param userEntity
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public Object save(HttpServletRequest request, DicTypeEntity entity){
		Json json = new Json();
		String uid = entity.getUid();
		if (!StringUtil.isValid(uid)) {//新增
			entity.setUid(PrimaryKey.createKey("d","yyyyMMddHHmmss",4));//主键
			try {
				dictypeService.add(entity);
			} catch (Exception e) {
				json.setSuccess(false);
				json.setMsg("新增失败！");
				return json;
			}
		}else {//更新
			try {
				dictypeService.update(entity);
			} catch (Exception e) {
				json.setSuccess(false);
				json.setMsg("更新失败！");
				return json;
			}
		}
		json.setSuccess(true);
		json.setMsg("保存成功！");
		return json;
	}
	/**
	 * 删除功能
	 * @author zhouq
	 * @create 2014年8月13日 下午1:41:38
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "detele")
	@ResponseBody
	public Object detele(String id,String pid){
		Json json = new Json();
		if (StringUtil.isValid(id)) {
			dictypeService.delete(id);
		}
		if (StringUtil.isValid(pid)) {
			dictypeService.delete(pid);
			dictypeService.deleteByPid(pid);
		}
		json.setSuccess(true);
		json.setMsg("删除成功！");
		return json;
	}	
}
