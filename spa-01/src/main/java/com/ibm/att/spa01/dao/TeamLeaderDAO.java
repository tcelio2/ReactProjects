package com.ibm.att.spa01.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ibm.att.spa01.bean.TeamLeaderBean;

public class TeamLeaderDAO {

    private Connection con = null;

    public TeamLeaderDAO() {
	  ConnectionDAO conDAO = new ConnectionDAO();
	  this.con = conDAO.getConection();
    }

    public List<TeamLeaderBean> selectAgileTeamLeader() {

	List<TeamLeaderBean> dlist = new ArrayList<TeamLeaderBean>();

	try {

	    PreparedStatement stmt = con.prepareStatement(
		    "SELECT application, release, project_id, project_name, prism_status, owner, target_ist, area, status, issue, comments, sprint, task, percentage, sprint_schedule, peer_review, docs_kms, cr, ist_schedule, hld, hld_owner, ad, ad_owner, utc, utc_owner, code, code_owner, ut, ut_owner, methodology FROM team_leader WHERE methodology = 'agile'");

	    ResultSet rs = stmt.executeQuery();

	    while (rs.next()) {

		TeamLeaderBean dBean = new TeamLeaderBean();

		dBean.setApplication(rs.getString("application"));
		dBean.setRelease(rs.getString("release"));
		dBean.setProjectId(rs.getString("project_id"));
		dBean.setProjectName(rs.getString("project_name"));
		dBean.setPrismStatus(rs.getString("prism_status"));
		dBean.setOwner(rs.getString("owner"));
		dBean.setTargetIst(rs.getString("target_ist"));
		dBean.setArea(rs.getString("area"));
		dBean.setStatus(rs.getString("status"));
		dBean.setIssue(rs.getString("issue"));
		dBean.setComments(rs.getString("comments"));
		dBean.setSprint(rs.getString("sprint"));
		dBean.setTask(rs.getString("task"));
		dBean.setPercentage(rs.getInt("percentage"));
		dBean.setSprintSchedule(rs.getString("sprint_schedule"));
		dBean.setPeerReview(rs.getString("peer_review"));
		dBean.setDocsKms(rs.getString("docs_kms"));
		dBean.setCr(rs.getString("cr"));
		dBean.setIstSchedule(rs.getString("ist_schedule"));
		dBean.setHld(rs.getString("hld"));
		dBean.setHldOwner(rs.getString("hld_owner"));
		dBean.setAd(rs.getString("ad"));
		dBean.setAdOwner(rs.getString("ad_owner"));
		dBean.setUtc(rs.getString("utc"));
		dBean.setUtcOwner(rs.getString("utc_owner"));
		dBean.setCode(rs.getString("code"));
		dBean.setCodeOwner(rs.getString("code_owner"));
		dBean.setUt(rs.getString("ut"));
		dBean.setUtOwner(rs.getString("ut_owner"));
		dBean.setMethodology(rs.getString("methodology"));

		dlist.add(dBean);

	    }
	    stmt.close();

	} catch (Exception e) {
	    System.out.println("Fail on select: " + e.getMessage());
	}

	return dlist;
    }

    public List<TeamLeaderBean> selectWaterfallTeamLeader() {

	List<TeamLeaderBean> dlist = new ArrayList<TeamLeaderBean>();

	try {

	    PreparedStatement stmt = con.prepareStatement(
		    "SELECT application, release, project_id, project_name, prism_status, owner, target_ist, area, status, issue, comments, sprint, task, percentage, sprint_schedule, peer_review, docs_kms, cr, ist_schedule, hld, hld_owner, ad, ad_owner, utc, utc_owner,code, code_owner, ut, ut_owner, methodology FROM team_leader WHERE methodology = 'waterfall'");

	    ResultSet rs = stmt.executeQuery();

	    while (rs.next()) {

		TeamLeaderBean dBean = new TeamLeaderBean();

		dBean.setApplication(rs.getString("application"));
		dBean.setRelease(rs.getString("release"));
		dBean.setProjectId(rs.getString("project_id"));
		dBean.setProjectName(rs.getString("project_name"));
		dBean.setPrismStatus(rs.getString("prism_status"));
		dBean.setOwner(rs.getString("owner"));
		dBean.setTargetIst(rs.getString("target_ist"));
		dBean.setArea(rs.getString("area"));
		dBean.setStatus(rs.getString("status"));
		dBean.setIssue(rs.getString("issue"));
		dBean.setComments(rs.getString("comments"));
		dBean.setSprint(rs.getString("sprint"));
		dBean.setTask(rs.getString("task"));
		dBean.setPercentage(rs.getInt("percentage"));
		dBean.setSprintSchedule(rs.getString("sprint_schedule"));
		dBean.setPeerReview(rs.getString("peer_review"));
		dBean.setDocsKms(rs.getString("docs_kms"));
		dBean.setCr(rs.getString("cr"));
		dBean.setIstSchedule(rs.getString("ist_schedule"));
		dBean.setHld(rs.getString("hld"));
		dBean.setHldOwner(rs.getString("hld_owner"));
		dBean.setAd(rs.getString("ad"));
		dBean.setAdOwner(rs.getString("ad_owner"));
		dBean.setUtc(rs.getString("utc"));
		dBean.setUtcOwner(rs.getString("utc_owner"));
		dBean.setCode(rs.getString("code"));
		dBean.setCodeOwner(rs.getString("code_owner"));
		dBean.setUt(rs.getString("ut"));
		dBean.setUtOwner(rs.getString("ut_owner"));
		dBean.setMethodology(rs.getString("methodology"));

		dlist.add(dBean);

	    }
	    stmt.close();

	} catch (Exception e) {
	    System.out.println("Fail on select: " + e.getMessage());
	}

	return dlist;
    }

}
