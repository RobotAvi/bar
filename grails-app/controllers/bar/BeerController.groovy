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
        if (Beer.count() > 5) {
            def mem = Beer.list().get(6)
            render mem as JSON
        } else {
            redirect(controller: "Beer", action: "table")
        }
    }

    def get3d() {

        //key is id of Member,value is index in matrix. Actually, more logical to use HashSet here.
        def giverMap = [:]
        def receiverMap = [:]

        //coordinates between giver/receiver
        def xIndex = 0
        def yIndex = 0

        //key is coordinates in matrix, value is amount
        def matrixMap = [:]
        def giverReceiverCoords


        for (Beer b : Beer.list()) {
            //Collect all giver indexes
            if (!giverMap[b.giver.id]) {
                xIndex++
                giverMap.put(b.giver.id, xIndex)

            }

            //Collect all receiver indexes
            if (!receiverMap[b.receiver.id]) {
                yIndex++
                receiverMap.put(b.receiver.id, yIndex)
            }

            giverReceiverCoords = new Integer[2]
            giverReceiverCoords[0] = xIndex - 1
            giverReceiverCoords[1] = yIndex - 1

            matrixMap.put(giverReceiverCoords, b.amount)

        }

        //Fill matrix by zero
        def matrix = new Integer[xIndex][yIndex]
        for (int i = 0; i < xIndex; i++) {
            for (int j = 0; j < yIndex; j++) {
                matrix[i][j] = 0
            }
        }

        //fill matrix by amounts
        matrixMap.each { k, v ->
            matrix[k[0]][k[1]] = v
        }

        render view: "3dsurface", model: [beersMatrix: matrix as JSON]
    }


}


