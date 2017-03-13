package bar

class Beer {
	Member giver
	Member receiver
	Date dateCreated
	int amount
	
    static constraints = {
         giver unique: 'receiver' , validator: { val, obj -> return !obj.receiver.equals(val)		 
         receiver unique: 'giver'	
		}
	}	
}
