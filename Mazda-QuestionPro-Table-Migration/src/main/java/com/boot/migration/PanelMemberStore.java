package com.boot.migration;

import java.util.Map;

import com.boot.questionpro.entity.PanelMember;

public class PanelMemberStore {

	public static Map<String, PanelMember> panelMembersMap;

	public static Map<String, PanelMember> getPanelMembersMap() {
		return panelMembersMap;
	}

	public static void setPanelMembersMap(Map<String, PanelMember> panelMembersMap) {
		PanelMemberStore.panelMembersMap = panelMembersMap;
	}

	public static void putPanelMember(PanelMember panelMember) {
		PanelMemberStore.panelMembersMap.put(panelMember.getEmailAddress(), panelMember);
	}

	public static PanelMember getPanelMember(String id) {
		return PanelMemberStore.panelMembersMap.get(id);
	}

}
