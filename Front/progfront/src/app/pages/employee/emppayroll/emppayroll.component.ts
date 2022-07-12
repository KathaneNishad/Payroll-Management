import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { LeaveserviceService } from 'src/app/services/leaveservice.service';
import { LoginService } from 'src/app/services/login.service';
import { PayrollService } from 'src/app/services/payroll.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-emppayroll',
  templateUrl: './emppayroll.component.html',
  styleUrls: ['./emppayroll.component.css']
})
export class EmppayrollComponent implements OnInit {

  pay={"user_id":"",
        "designation":"",
};

  constructor(private userService:UserService,
    private snack:MatSnackBar,
    private leaveService:LeaveserviceService,
    public login:LoginService,
    private payroll:PayrollService) { }

  ngOnInit(): void {
  }

  generatePayroll(){
    this.pay.user_id=this.login.getUser().id;
    this.pay.designation=this.login.getUser().designation;
    console.log(this.pay);
    this.payroll.generatePayroll(this.pay).subscribe((data: any)=>{
      //success
      console.log("success");
      this.snack.open("Employee PaySlip Generate ",'',{
        duration:3000,
        
      })
    },
    (error:any)=>{
      //error
      this.snack.open("Payslip Exists !! Proceed to View Payslip",'',{
        duration:2000,
        
      })
    });
  }

}
