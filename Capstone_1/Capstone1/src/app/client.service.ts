import { Injectable } from '@angular/core';
import { ClientInfo } from './clientInfo';
@Injectable({
  providedIn: 'root'
})
export class ClientService {
  private listOfClients : ClientInfo[] = []
  

  constructor() {
    this.listOfClients.push({clientName: "Nike"     , clientPhone: 503-567-6789})
    this.listOfClients.push({clientName: "Adidas"   , clientPhone: 503-234-2345})
    this.listOfClients.push({clientName: "Kmark"    , clientPhone: 503-890-9012})
  }
  
      getClientList()   : ClientInfo[] {
        return this.listOfClients;
      }
      addClient(newClient : ClientInfo) {
        console.table(newClient)
        this.listOfClients.push(newClient)
        console.table(this.listOfClients)
      }

      
}
