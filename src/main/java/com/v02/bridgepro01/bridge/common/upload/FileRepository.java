package com.v02.bridgepro01.bridge.common.upload;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface FileRepository {



    @Insert("INSERT INTO files (file_name, file_type, data) VALUES (#{fileName}, #{fileType}, #{data})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertFile(FileDTO fileDto);

    @Select("SELECT * FROM files WHERE id = #{id}")
    FileDTO getFile(Long id);


}
