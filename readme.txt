1) User H2 db . Username- ua , Passoword -
2) We can see the changes in db by hitting localhost:8080/h2
3) First need to create account using the below api
  /addCustomer

{
    "firstName":"shikhar",
    "lastName":"singh",
    "address":"2-a indra",
    "contactDetails":"9643610994",
    "account":[{
        "pin":"2354",
        "ammount":"10000"
    }]
}

4) localhost:8080/account/withdraw/2/1000
where 2 is account number and 100 is withdrwal amount

5) localhost:8080/account/deposit/2/1000
where 2 is account number and 100 is deposit amount

6)localhost:8080/account/amount/2
where 2 is account number