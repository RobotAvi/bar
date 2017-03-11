package bar

class BeerController {

    static scaffold = Beer
	def beerService
	def fill(){
		render beerService.createRandomBeers()
		
		//		redirect(controller: "Beer", action: "index")
	}
	
	def clear(){
		beerService.clearBeers()
		redirect(controller: "Beer", action: "index")
	}
}
