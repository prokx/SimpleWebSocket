package com.hwan.websocket.controller;

import com.hwan.websocket.dto.ChatRoomDTO;
import com.hwan.websocket.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/chat")
@Log4j2
public class RoomController {

    private final ChatRoomRepository repository;

    //채팅방 목록 조회
    @GetMapping(value = "/rooms")
    public List<ChatRoomDTO> rooms(){

        log.info("# All Chat Rooms");

        return repository.findAllRooms();
    }

    //채팅방 개설
    @PostMapping(value = "/room")
    public int create(@RequestParam String name){

        log.info("# Create Chat Room , name: " + name);

        repository.createChatRoomDTO(name);

        return 0;
    }

    //채팅방 조회
    @GetMapping("/room")
    public ChatRoomDTO getRoom(String roomId, Model model){

        log.info("# get Chat Room, roomID : " + roomId);

        return repository.findRoomById(roomId);
    }
}