package com.bosy.fwfc.controller;

import org.springframework.stereotype.Controller;


/**
 * @author Administrator
 */
@Controller
public class CategoryController {

//    @Autowired
//    CategoryService categoryService;
//
//    @RequestMapping("/listCategory")
//    public ModelAndView listCategory(Page page) {
//        int total = categoryService.total();
//        page.caculateLast(total);
//        if (page.getStart() <= 0) {
//            page.setStart(0);
//        } else if (page.getStart() >= total) {
//            page.setStart(page.getLast());
//        }
//        ModelAndView mav = new ModelAndView();
//        List<Category> cs = categoryService.list(page);
//        mav.addObject("cs", cs);
//        mav.setViewName("listCategory");
//        return mav;
//    }
//
//    //	public ModelAndView listCategory(){
////
////		ModelAndView mav = new ModelAndView();
////		List<Category> cs = categoryServiceImpl.list();
////		mav.addObject("cs",cs);
////		mav.setViewName("listCategory");
////		return mav;
////	}
//    @RequestMapping("addCategory")
//    public ModelAndView addCategory(Category category) {
//        categoryService.add(category);
//        ModelAndView mav = new ModelAndView("redirect:/listCategory");
//        return mav;
//    }
//
//    @RequestMapping("deleteCategory")
//    public ModelAndView deleteCategory(Category category) {
//        categoryService.delete(category);
//        ModelAndView mav = new ModelAndView("redirect:/listCategory");
//        return mav;
//    }
//
//    @RequestMapping("editCategory")
//    public ModelAndView editCategory(Category category) {
//        Category c = categoryService.get(category.getId());
//        ModelAndView mav = new ModelAndView("editCategory");
//        mav.addObject("c", c);
//        return mav;
//    }
//
//
//    @RequestMapping("updateCategory")
//    public ModelAndView updateCategory(Category category) {
//        categoryService.update(category);
//        ModelAndView mav = new ModelAndView("redirect:/listCategory");
//        return mav;
//    }
//
//    @RequestMapping("test")
//    public ModelAndView test(){
//        ModelAndView mav = new ModelAndView("test");
//        return  mav;
//    }

}
