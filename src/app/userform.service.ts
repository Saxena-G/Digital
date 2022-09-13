import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import User from './entity/User';
const Rest_API="http://localhost:9080/user/"

@Injectable({
  providedIn: 'root'
})
export class UserformService {


  constructor(public client:HttpClient) { }

  deleteUser(userid: number){
    return this.client.delete(Rest_API + userid);
  }

getUsers(){
  return this.client.get(Rest_API);
}

  saveUser(user:User){
    return this.client.post(Rest_API,user);
  }
}
