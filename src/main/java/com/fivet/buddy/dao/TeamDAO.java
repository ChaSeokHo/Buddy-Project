package com.fivet.buddy.dao;

import com.fivet.buddy.dto.TeamDTO;
import com.fivet.buddy.dto.TeamMemberDTO;
import com.fivet.buddy.mapper.TeamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class TeamDAO {
    @Autowired
    private TeamMapper teamMapper;

    // 팀 생성
    public void insertTeam(TeamDTO teamDto) {
        teamMapper.insertTeam(teamDto);
    }
    // 회원이 속한 팀 출력
    public List<TeamDTO> selectMemberTeam(int memberSeq) {
        return teamMapper.selectMemberTeam(memberSeq);
    }

    //팀 관리 팀 이름 출력
    public TeamDTO selectTeamOne(String teamSeq){
        return teamMapper.selectTeamOne(teamSeq);
    }

    //팀 관리 팀 이름 수정
    public void updateManagementTeamName(TeamDTO teamDto){
        teamMapper.updateManagementTeamName(teamDto);
    }

    //팀 삭제
    public void deleteTeam(int teamSeq){
        teamMapper.deleteTeam(teamSeq);
    }

    // 팀 이름으로 회원 출력
    public String selectTeamName(int teamSeq) {
        return teamMapper.selectTeamName(teamSeq);
    }

    //팀 관리에서 매니저가 바뀌면 team_owner_seq 변경
    public void updateTeamOwnerSeq(Map<String,Integer> param){
        teamMapper.updateTeamOwnerSeq(param);
    }

    //새로운 팀원 추가시, 팀 인원을 +1
    public void updatePlusTeamCount(int teamSeq) { teamMapper.updatePlusTeamCount(teamSeq);}

    //새로운 팀원 감소시, 팀 인원을 -1
    public void updateMinusTeamCount(int teamSeq) { teamMapper.updateMinusTeamCount(teamSeq);}

    //팀원 0명인 팀 제거
    public void delTeamZeroCount() { teamMapper.delTeamZeroCount(); };
}
