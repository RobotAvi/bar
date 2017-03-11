package bar

class TableController {

    def table() { 
		[ member: Beer]		
	}

	def index(){
		redirect action:"table"	
	}
}
