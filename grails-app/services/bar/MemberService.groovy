package bar

import grails.transaction.Transactional

@Transactional
class MemberService {

    def createRandomMembers() {
        def m
        for (int i = 0; i < 10; i++) {
            m = new Member(name: "Agent 00" + i, email: "james" + i + "@gmail.com", birthdate: new Date())
            m.save()
        }
    }

    def clearMembers() {
        Member.executeUpdate('delete from Member')
    }
}
