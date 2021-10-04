
# KriptoWallet

The purpose of this project is to return the information of the wallets whose hash code is given in the smart chain(Bscscan) browser and to send an alert in case of transactions in those wallets.


## API Usage

#### Find Wallet

```http
  POST /wallet/find
```

| Parametre | Tip     | Açıklama                |
| :-------- | :------- | :------------------------- |
| `walletHashCode` | `string` | **Required**. Hash code of the wallet you want to track |

#### Others
...


  
## Developers

- Design and develop by [@arifaydogan](https://www.github.com/arifaydogan)

  
## Contribution

Contributions are always welcome!

  
## Environment Variables

To run this project you will need to add the following environment variables to your .env file

`API_KEY` --> Required for bscscan api

  
## Feedback

If you have any feedback, please contact me at [@arifaydogan](https://www.github.com/arifaydogan).

  
## Licence

[MIT](https://choosealicense.com/licenses/mit/)

  
## RoadMap

- Integration into more chain networks (ethscan etc.)

  
## Bilgisayarınızda Çalıştırın

Clone the project

```bash
  git clone https://github.com/arifaydogan/kriptowallet.git
```

Go to the project directory

```bash
  cd kriptowallet
```

Install required packages and build

```bash
  mvn clean install
```

Run Application

```bash
  java -jar kriptowallet.jar
```

  Show on Swagger

  ```bash
  http://localhost:8888/kripto/swagger-ui.html
```
## Used Technologies

Spring Boot, BscScan API , Maven

  
