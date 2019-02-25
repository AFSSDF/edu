package com.bdqn.edu.mapper;

import com.bdqn.edu.entity.Room;

import java.util.List;

/**
 * <p>
 * 教室信息 Mapper 接口
 * </p>
 *
 * @author Li
 * @since 2019-02-19
 */
public interface RoomMapper {

    int insertRoom(Room room);

    int updateRoom(Room room);

    int deleteRoom(Long id);

    List<Room> listRoom();

    Integer countRoom();

    Room selectRoomById(Long id);
}
