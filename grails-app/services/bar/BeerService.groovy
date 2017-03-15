package bar

import grails.transaction.Transactional

@Transactional
class BeerService {

    //Methods for generating some trash for presentation
    def memberService

    def createRandomBeers() {
        if (Member.count() < 2) {
            memberService.createRandomMembers()
        }
        def allMembers = Member.getAll()
        def randomGiverIdx
        def randomReceiverIdx
        def randomBeerCountIdx
        def newBeer

        for (int i = 0; i < 100; i++) {
            randomGiverIdx = new Random().nextInt(allMembers.size())
            randomReceiverIdx = new Random().nextInt(allMembers.size())
            while (randomGiverIdx == randomReceiverIdx) {
                randomReceiverIdx = new Random().nextInt(allMembers.size())
                randomGiverIdx = new Random().nextInt(allMembers.size())
            }
            randomBeerCountIdx = new Random().nextInt(100)

            newBeer = new Beer(giver: allMembers[randomGiverIdx], receiver: allMembers[randomReceiverIdx], dateCreated: new Date(), amount: randomBeerCountIdx)
            newBeer.save()
        }
    }

    def clearBeers() {
        Beer.executeUpdate('delete from Beer')
    }

    def clearAll() {
        clearBeers()
        memberService.clearMembers()
    }
}
