package MembershipORM.src.view.memberdetail;

import MembershipORM.src.dao.JenisMemberDao;
import MembershipORM.src.dao.MemberDao;
import MembershipORM.src.model.JenisMember;
import MembershipORM.src.model.Member;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MemberDetailFrame extends JFrame {

    private JTextField textFieldId;
    private JTextField textFieldNama;
    private Member member;
    private MemberDao memberDao;
    private JComboBox comboJenis;
    private List<JenisMember> jenisMemberList;
    private JenisMemberDao jenisMemberDao;

    public MemberDetailFrame(Member member, MemberDao memberDao, JenisMemberDao jenisMemberDao) {
        this.member = member;
        this.memberDao = memberDao;
        this.jenisMemberDao = jenisMemberDao;
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel labelId = new JLabel("ID:");
        labelId.setBounds(15, 40, 350, 10);
        textFieldId = new JTextField(member.getId());
        textFieldId.setBounds(15, 60, 350, 30);
        textFieldId.setEditable(false);  // ID tidak bisa diedit

        JLabel labelNama = new JLabel("Nama:");