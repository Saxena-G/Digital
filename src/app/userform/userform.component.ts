import { Component, OnInit } from '@angular/core';
import User from '../entity/User';
import { UserformService } from '../userform.service';

@Component({
  selector: 'app-userform',
  templateUrl: './userform.component.html',
  styleUrls: ['./userform.component.scss']
})
export class UserformComponent implements OnInit {
  user: User = new User('Gaurav', 25, 'saxenag381@gmail.com');
  users: any = [];

  constructor(public userformservice: UserformService) { }
  ngOnInit(): void {
    this.getUsers();
  }

  private getUsers() {
    const observable = this.userformservice.getUsers();
    observable.subscribe(users => {
      this.users = users;
    })
  }

  deleteUser(userid: number) {
    const observable = this.userformservice.deleteUser(userid);
    observable.subscribe(response => {
      this.getUsers();
    })
  }

  save() {
    console.log('clicked')
    const observable = this.userformservice.saveUser(this.user);
    observable.subscribe((response) => {
      console.log(response);
    })
  }

}
