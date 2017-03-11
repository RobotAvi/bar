package bar

import grails.transaction.Transactional

@Transactional
class BeerService {

    def createRandomBeers() {
		if (Member.count() > 2){
			def allMembers = Member.getAll()
			def randomGiverIdx
			def randomReceiverIdx
			def randomBeerCountIdx
			def newBeer
			println "allMembers.size():"+allMembers.size()
			
			for (int i=0;i<10;i++){
				randomGiverIdx = new Random().nextInt(allMembers.size())
				randomReceiverIdx = new Random().nextInt(allMembers.size())
				while (randomGiverIdx == randomReceiverIdx) {
					randomReceiverIdx = new Random().nextInt(allMembers.size())
					randomGiverIdx = new Random().nextInt(allMembers.size())
				}
				randomBeerCountIdx = new Random().nextInt(10)		
				println "i:" + i
				println "allMembers[randomGiverIdx]:"+ allMembers[randomGiverIdx].name
				println "allMembers[randomReceiverIdx]:" + allMembers[randomReceiverIdx].name
				println "randomBeerCountIdx:" + randomBeerCountIdx
				println "dateCreated" + new Date()
				newBeer = new Beer(giver: allMembers[randomGiverIdx], receiver: allMembers[randomReceiverIdx] , dateCreated: new Date() , amount: randomBeerCountIdx)
				newBeer.save()
			}
			return "Ok"
		}else{
			return "Please fill members first."
		}
    }
	
	def clearBeers(){
		Beer.executeUpdate('delete from Beer')
	}
}
