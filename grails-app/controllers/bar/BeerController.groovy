package bar

import grails.converters.JSON

class BeerController {

    static scaffold = Beer

    def beerService

    def fill() {
        beerService.createRandomBeers()

        redirect(controller: "Beer", action: "table")
    }

    def clear() {
        beerService.clearBeers()
        redirect(controller: "Beer", action: "table")
    }

    def clearAll() {
        beerService.clearAll()
        redirect(controller: "Beer", action: "table")
    }

    def table() {
        [beerList: Beer.list(), beerCount: Beer.count()]
    }

    def json() {

        def mem = Beer.get(6)
        if (mem != null) {
            render mem as JSON
        } else {
            render text: """<script type="text/javascript">
                    alert("Beer with id 6 := ${Beer.get(6)} so returning full list of beers" ); 
                </script>""",
                    contentType: 'js'
            render Beer.list() as JSON
        }

    }

    def getJson() {

    }
}


