To run compiled application :

java -jar TransactionManager-0.0.1-SNAPSHOT.jar 

To compile application

mvn clean package

Endpoints: 

    GET REQUESTS: 
        api/transactions - get request to fetch transactions 
        api/transactions/{id} - get request to fetch exact transaction by id
        api/balance - get request to fetch current balance 
        
    POST REQUEST
        api/transaction - post request to add transaction 
        request body example :
        {
            type: "debit"
            amount: 1233332.45
        }    
        
        type - possible values: "debit" or "credit" 
        amount - non-negative number    
                
            
        