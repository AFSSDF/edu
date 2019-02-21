package com.bdqn.edu.service;

import com.bdqn.edu.entity.Room;

import java.util.List;

/**
 * <p>
 * 教室信息 服务类
 * </p>
 *
 * @author Li
 * @since 2019-02-19
 */
public interface RoomService {
    int saveRoom(Room room);

    int modifyRoom(Room room);

    int removeRoom(Long id);

    List<Room> findRoomList();

    Integer countRoom();

    Room findRoomById(Long id);

}
