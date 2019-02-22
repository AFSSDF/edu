package com.bdqn.edu.controller;


import com.bdqn.edu.entity.Room;
import com.bdqn.edu.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.ArrayList;

/**
 * <p>
 * 教室信息 前端控制器
 * </p>
 *
 * @author Li
 * @since 2019-02-19
 */
@Controller
public class RoomController {
    @Autowired
    private RoomService roomService;

    @GetMapping("/room-list.html")
    public String roomList(Model model) {
        model.addAttribute("list", roomService.findRoomList());
        return "room-list";
    }

    @GetMapping("/room-add.html")
    public String toAddRoomView(Model model, String msg, @ModelAttribute Room room) {
        model.addAttribute("opt", 1);
        return "room-edit";
    }

    @GetMapping("/room-modify.html")
    public String toModifyRoomView(Model model, String msg, Long id) {
        model.addAttribute("opt", 0);
        model.addAttribute("room", roomService.findRoomById(id));
        return "room-edit";
    }

    @PostMapping("/room-add-save.html")
    public String doAddSaveRoom(Model model, Room room) {
        model.addAttribute("opt", 1);
        int result = roomService.saveRoom(room);
        String msg;
        if (result == 1) {
            msg = "添加成功";
        } else {
            msg = "添加失败";
        }
        model.addAttribute("msg", msg);
        return "room-edit";
    }

    @PostMapping("/room-modify-save.html")
    public String doAddModifyRoom(Model model, Room room) {
        int result = roomService.modifyRoom(room);
        model.addAttribute("opt", 0);
        String msg;
        if (result == 1) {
            msg = "修改成功";
        } else {
            msg = "修改失败";
        }
        model.addAttribute("msg", msg);
        return "room-edit";
    }

    @ResponseBody
    @GetMapping("/delete-room.html")
    public Object deleteRoom(Long id) {
        return roomService.removeRoom(id) == 1 ? "" : new ArrayList();
    }

    @ResponseBody
    @GetMapping("/roomList")
    public Object roomList(){
        return roomService.findRoomList();
    }
}
