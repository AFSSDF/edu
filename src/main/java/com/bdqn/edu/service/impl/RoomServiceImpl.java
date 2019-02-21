package com.bdqn.edu.service.impl;

import com.bdqn.edu.entity.Room;
import com.bdqn.edu.mapper.RoomMapper;
import com.bdqn.edu.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 教室信息 服务实现类
 * </p>
 *
 * @author Li
 * @since 2019-02-19
 */
@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomMapper roomMapper;

    @Override
    public int saveRoom(Room room) {
        return roomMapper.insertRoom(room);
    }

    @Override
    public int modifyRoom(Room room) {
        return roomMapper.updateRoom(room);
    }

    @Override
    public int removeRoom(Long id) {
        return roomMapper.deleteRoom(id);
    }

    @Override
    public List<Room> findRoomList() {
        return roomMapper.listRoom();
    }

    @Override
    public Integer countRoom() {
        return roomMapper.countRoom();
    }

    @Override
    public Room findRoomById(Long id) {
        return roomMapper.selectRoomById(id);
    }
}
