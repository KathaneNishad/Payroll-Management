import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { LeaveserviceService } from 'src/app/services/leaveservice.service';
import { LoginService } from 'src/app/services/login.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-leave-chart',
  templateUrl: './leave-chart.component.html',
  styleUrls: ['./leave-chart.component.css']
})
export class LeaveChartComponent implements OnInit {

  public leavesCategories = [

  ] as any;

  constructor(
    private userService:UserService,
    private snack:MatSnackBar,
    private leaveService:LeaveserviceService,
    public login:LoginService,
  ) { }

  ngOnInit(): void {
    this.leaveService.displayLeaveChart().subscribe(data=>this.leavesCategories=data);
  }

  getTotal() {
    let total = 0;
    for (var i = 0; i < this.leavesCategories.length; i++) {
        if (this.leavesCategories[i].noOfLeaves) {
            total += this.leavesCategories[i].noOfLeaves;
         //   this.leavesCategories = total;
        }
    }
    return total;
}
}
