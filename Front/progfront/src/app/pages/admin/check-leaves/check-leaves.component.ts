import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { LeaveserviceService } from 'src/app/services/leaveservice.service';
import { LoginService } from 'src/app/services/login.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-check-leaves',
  templateUrl: './check-leaves.component.html',
  styleUrls: ['./check-leaves.component.css']
})
export class CheckLeavesComponent implements OnInit {
  public leaves = [

  ] as any;

  public name:any={};

  public Statuses = [
    {value:"Pending"},
    {value:"Approved"},
  {value:"Rejected"},
];


  


  constructor(
    public userService:UserService,
    private snack:MatSnackBar,
    private leaveService:LeaveserviceService,
    public login:LoginService,
  ) { }

  ngOnInit(): void {
        this.leaveService.getAllLeave().subscribe(data=>this.leaves=data);

  }
  
  updateLeave(leave:any){
    console.log(leave);
    this.leaveService.editLeaves(leave).subscribe();
  }

}
