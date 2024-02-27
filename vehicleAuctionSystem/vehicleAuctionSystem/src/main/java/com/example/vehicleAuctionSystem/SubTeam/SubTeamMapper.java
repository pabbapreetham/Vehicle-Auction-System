package com.example.vehicleAuctionSystem.SubTeam;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SubTeamMapper {

    // SELECT query to get all subteams
    @Select("SELECT * from SubTeam st")
    List<SubTeam> getSubTeams();

    // SELECT query to get subteams under a company
    @Select("SELECT * from SubTeam st WHERE st.companyId = #{companyId}")
    List<SubTeam> getSubTeamsForCompany(int companyId);

    // INSERT query to add subteam details
    @Insert("INSERT INTO SubTeam (subTeamName, addressId, companyId, country) " +
            "VALUES (#{subTeamName}, #{addressId} , #{companyId},  #{country});")
    boolean createSubTeam(SubTeam subTeam);
}
