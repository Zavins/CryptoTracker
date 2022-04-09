# CRYPTO TRACKING

## 
1. [App Evaluation](#Overview)
2. [APIs](#APIs)
3. [Product Spec](#Product-Spec)
4. [Further Implementation](#Further-Implementation)
5. [Wireframes](#Wireframes)

## Overview
### Description
An app to track up-to-dated cryptocurrencies.

### App Evaluation
[App that is designed for tracking cryptocurrencies in 21st Century]

**Category**
- crypto market / Different types of crypto asset/ pricing tell/ and news about market teller** 

**Mobile**:
- Website is view only, Which Mobile is use for the user can see the status of the crypto and see the current and new updated news in crypto **

**Story**:
- Any one who is interested in crypto could use it to view the market price of the crypto and news related to crypto and user has option to choose whatever crypto is they are more interested and get notify when their favorite crypto asset up or dow. 

**Market**:
- Since everyone is getting in to crypto invest this could be sparking app.  which is everyone who has interesting in the market   will be enjoying this app, which they can easily watch the price fluctuate of crypto in their phone with single touch on it, And decided to whether they can invest or to sell their asset, and they can easily watch the news related to the crypto in app.. And also the app will notify them if their favorite crypto asset will bullied or beared to take some action on their asset

**Habit**:
- Users can change whenever they need to track their favorite crypto, and users can also see the news of crypto every day when they open their app.

**Scope:
  CrypotTracker is narrowly focused on crypto assets and news of crypto. This app will have a huge advantage to the hodles in crypto to see the status of the market easily with their phone app instead of going to google and searching for the market.

## APIs
**APIs implemented**
- **Cryptocurrency data:**
- **Recent news:**


## Product Spec
[By using the app, users are allowed to track the prices of cryptocurrencies, checking the most recent news and events about the cryptocurrency market]
### 1. User Stories (Required and Optional)

**Required Must-have Stories**

* Local Profile pages for each user
* Main page have searching bar to search for cryptocurrencies.
* Show most gain/most loss.
* Show popular cryptocurrencies on the main page.
* Price Conversion from one currency to another.

**Optional Nice-to-have Stories**

* Trading cryptocurrencies.

### 2. Screen Archetypes

* Main page

#### 3. Navigation

**Tab Navigation** (Tab to Screen)
* Up-to-dated cryptocurrencies data market
* News Page


** Flow Navigation (Screen to Screen)
* Clicked on the app -> Show Main page showing the market data
* Each cryptocurrency has a button, clicking it redirectes the user to a new screen that shows the graph of price trend, highest price, lowest price, average price...
* News Selection -> Showing news page with the newest news about


##Further-Implementation

* Search for transactions by hash for cryptocurrencies.
* Posting threads to the community
* Add favorite cryptocurrencies

## Wireframes
[Add picture of your hand sketched wireframes in this section]
<img src="./20220407_124144.jpg" width=600>

### [BONUS] Digital Wireframes & Mockups

### [BONUS] Interactive Prototype

## Schema 
[This section will be completed in Unit 9]
### Models
#### Cryptocurrencies

   | Property             | Type     | Description                                                                                                         |
   | -------------------- | -------- | ------------------------------------------------------------------------------------------------------------------- |
   | id                   | String   | id of the currency                                                                                                  |
   | currency             | String   | type of currency                                                                                                    |
   | symbol               | String   | symbol of currency                                                                                                  |
   | name                 | String   | name of currency                                                                                                    |
   | logo_url             | String   | logo of currency                                                                                                    |
   | status               | String   | status of currency                                                                                                  |
   | platform_currency    | String   | platform of currency                                                                                                |
   | price                | Double   | current price of currency                                                                                           |
   | price_date           | String   | the date of the current price                                                                                       |
   | price_timestamp      | String   | the price at the exact moment when the block has been mined and validated by the blockchain network                 |
   | max_supply           | Int      | the maximum number of coins or tokens that will be ever created                                                     |
   | market_cap           | Int      | the total value of all the coins that have been mined                                                               |
   | market_cap_dominance | Double   | the ratio between the market capitalization of currency to the total market cap of the entire cryptocurrency market |
   | num_exchanges        | Int      | number of the amount has been exchanged                                                                             |
   | num_pairs            | Int      | assets that can be traded for each other on an exchange                                                             |
   | num_pairs_unmapped   | Int      | unmapped assets that can be traded for each other on an exchange                                                    |
   | first_candle         | String   | first price activity of an asset                                                                                    |
   | first_trade          | String   | first trade activity of an asset                                                                                    |
   | first_order_book     | String   | first electronic list of buy and sell orders for a security or other instrument organized by price level            |
   | rank                 | Int      | rank of the currency                                                                                                |
   | rank_delta           | Int      | rank of a risk metric that estimates the change in price of a derivative                                            |
   | high                 | Double   | the highest price a trader paid for an asset                                                                        |
   | high_timestamp       | String   | the exact moment of the highest price at when the block has been mined and validated by the blockchain network         |

#### DayChange

   | Property             | Type     | Description                                                                   |
   | -------------------- | -------- | ----------------------------------------------------------------------------- |
   | volume               | Double   | the sum total of actual trades taking place                                   |
   | price_change         | Double   | price change in n day(s)                                                      |
   | price_change_pct     | Double   | percentage of price change in n day(s)                                        |
   | volume_change        | Double   | the change of volume in n day(s)                                              |
   | volume_change_pct    | Double   | percentage of the change of volume in n day(s)                                |
   | market_cap_change    | String   | the change of total value of all the coins that have been mined               |
   | market_cap_change_pct| String   | the percentage of change of total value of all the coins that have been mined |

### Networking
- Home Feed Screen
(Read/GET) Query all posts where user is author
let query = PFQuery(className:"Notification")
query.whereKey("coin", equalTo: currentUser)
query.order(byDescending: "currentpriceHightest")
query.findObjectsInBackground { (notification: [PFObject]?, error: Error?) in
   if let error = error { 
      print(error.localizedDescription)
   } else if let notification = notifications {
      print("Successfully retrieved \(posts.count) posts.")
  // TODO: Do something with Notifiy the user about their coins up and down...
   }
}
(Chose/favorite) Notification when up and down. 
(Delete/Change) Delete the favorite coin you make
(Create/Save) Create a new screen to save your favorite coins
Create new screen to show you candleStick chart when you select in coin
(Create/back) Creat back to return to the all coins shows screen.
Profile Screen
(Read/GET) Query logged in user object
(Update/PUT) Update user profile image and Name

