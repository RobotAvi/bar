package bar

class MemberController {

    static scaffold = Member
    def memberService

    def fill() {
        memberService.createRandomMembers()
        redirect(controller: "Member", action: "index")
    }

    def clear() {
        memberService.clearMembers()
        redirect(controller: "Member", action: "index")
    }


}
