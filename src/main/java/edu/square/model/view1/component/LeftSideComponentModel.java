package edu.square.model.view1.component;

import edu.square.entity.Reminder;
import edu.square.model.component.MModel;
import edu.square.model.view1.widget.ReminderModel;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class LeftSideComponentModel extends MModel {
    private static final String[] BASE_GROUP_TITLES = {"All", "Today", "Completed", "Flagged"};
    @Getter
    private List<GroupModel> groupModels;


    public LeftSideComponentModel() {
        groupModels = queryBaseGroups();
    }

    public static void main(String[] args) {
        LeftSideComponentModel leftSideComponentModel = new LeftSideComponentModel();
        List<GroupModel> groupModels = leftSideComponentModel.getGroupModels();
        for (GroupModel groupModel : groupModels) {
            System.out.println(groupModel.getGroupName() + " : " + groupModel.getReminderModels().size());
            for (Reminder reminderModel : groupModel.getReminderModels()) {
                System.out.println(reminderModel.getContent());
            }
            System.out.println("=====================================");
        }
    }

    private List<GroupModel> queryBaseGroups() {
        List<GroupModel> list = new ArrayList<>();

        //Group - ALL
        list.add(new GroupModel(BASE_GROUP_TITLES[0], ReminderModel.queryAllEntities(false)));
        //Group - Today
        list.add(new GroupModel(BASE_GROUP_TITLES[1], ReminderModel.queryReminderOfToday()));
        //Group - Completed
        list.add(new GroupModel(BASE_GROUP_TITLES[2], ReminderModel.queryReminderByDoneStatus(false)));
        //Group - Flagged
        list.add(new GroupModel(BASE_GROUP_TITLES[3], ReminderModel.queryReminderByImportantStatus(true)));
        return list;
    }

    /**
     * Update groupModels
     * update group counter & reminder models
     */
    public void updateGroupModels() {
        groupModels = queryBaseGroups();
    }


    @Deprecated
    public List<GroupModel> queryGroupsByTag(String tag) {
        List<GroupModel> list = new ArrayList<>();
        list.add(new GroupModel(tag, ReminderModel.queryReminderByTag(tag)));
        return list;
    }

    @Deprecated
    public void addGroup(String groupName, List<Reminder> reminderModels) {
        groupModels.add(new GroupModel(groupName, reminderModels));
    }

    /**
     * Encapsulate reminders into groups
     */
    @Data
    public static class GroupModel {
        private String groupName;
        private List<Reminder> reminderModels;

        public GroupModel(String groupName, List<Reminder> reminderModels) {
            this.groupName = groupName;
            this.reminderModels = reminderModels;
        }
    }
}
