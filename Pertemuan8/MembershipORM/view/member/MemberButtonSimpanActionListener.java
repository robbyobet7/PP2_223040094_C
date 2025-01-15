package MembershipORM.src.view.member;

import MembershipORM.src.dao.MemberDao;
import MembershipORM.src.model.JenisMember;
import MembershipORM.src.model.Member;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;

public class MemberButtonSimpanActionListener implements ActionListener {

    private MemberFrame memberFrame;
    private MemberDao memberDao;

    public MemberButtonSimpanActionListener(MemberFrame memberFrame, MemberDao memberDao) {
        this.memberFrame = memberFrame;
        this.memberDao = memberDao;
    }

    public void actionPerformed(ActionEvent e){
        String nama = this.memberFrame.getName();
        if(nama.isEmpty()){
            this.memberFrame.showAlert("Nama tidak boleh kosong");
        } else {
            JenisMember jenisMember = this.memberFrame.getJenisMember();
            Member member = new Member();
            member.setId(UUID.randomUUID().toString());
            member.setNama(nama);
            member.setJenisMember(jenisMember);
            member.setJenisMemberId(jenisMember.getId());
            this.memberFrame.addMember(member);
            this.memberDao.insert(member);
            
        }
    }

}