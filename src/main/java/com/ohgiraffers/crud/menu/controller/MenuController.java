package com.ohgiraffers.crud.menu.controller;

import com.ohgiraffers.crud.menu.model.dto.CategoryDTO;
import com.ohgiraffers.crud.menu.model.dto.MenuDTO;
import com.ohgiraffers.crud.menu.model.service.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/menu") // index 참조
public class MenuController {

    /* Logger 객체 생성 */
    private static final Logger logger = LoggerFactory.getLogger(MenuController.class);

    private final MenuService menuService;

    private final MessageSource messageSource;

    // 생성자를 통한 의존성 주입
    public MenuController(MenuService menuService, MessageSource messageSource) {
        this.menuService = menuService;
        this.messageSource = messageSource;

    }

    @GetMapping("/list") // index 참조
    public String findMenuList(Model model){

        List<MenuDTO> menuList = menuService.findAllMenu();

        model.addAttribute("menuList", menuList);

        return "menu/list";
    }

    @GetMapping("/regist")
    public void registPage(){}


    @GetMapping("/category")
    public @ResponseBody List<CategoryDTO> findCategoryList() {

        return menuService.findAllCategory();
    }


    @PostMapping("/regist")
    public String registMenu(@ModelAttribute MenuDTO newMenu, Locale locale, RedirectAttributes rttr) {

        // 중괄호가 두번째 변수가 들어갈 위치를 나타낸다.
        logger.trace("locale : {}", locale);
        logger.debug("locale : {}", locale);
        logger.info("Locale : {}", locale);
        logger.warn("locale : {}", locale);
        logger.error("locale : {}", locale);


        menuService.registNewMenu(newMenu);

        rttr.addFlashAttribute("successMessage", messageSource.getMessage("registMenu", null, locale));

        return "redirect:/menu/list";
    }

}
