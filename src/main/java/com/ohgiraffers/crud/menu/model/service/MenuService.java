package com.ohgiraffers.crud.menu.model.service;

import com.ohgiraffers.crud.menu.model.dao.MenuMapper;
import com.ohgiraffers.crud.menu.model.dto.CategoryDTO;
import com.ohgiraffers.crud.menu.model.dto.MenuDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MenuService {

    private final MenuMapper menuMapper;

    // 생성자를 통한 DI 주입
    public MenuService(MenuMapper menuMapper) {
        this.menuMapper = menuMapper;
    }

    /* 메뉴 조회 */
    public List<MenuDTO> findAllMenu() { return menuMapper.findAllMenu(); }

    /* 카테고리 조회 */
    public List<CategoryDTO> findAllCategory() { return menuMapper.findAllCategory(); }

    /* 메뉴 등록 */
    @Transactional // 간편하게 트랜잭션
    public void registNewMenu(MenuDTO newMenu) {
        menuMapper.registMenu(newMenu);
    }
}
