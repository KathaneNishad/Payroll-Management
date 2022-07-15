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
paydata:any={};

  constructor(private userService:UserService,
    private snack:MatSnackBar,
    private leaveService:LeaveserviceService,
    public login:LoginService,
    private payroll:PayrollService) { }

  ngOnInit(): void {
    this.generatePayroll();
    this.payroll.getPayrollByUserId(this.login.getUser().id).subscribe(data=>this.paydata=data);
  }

  generatePayroll(){
    this.pay.user_id=this.login.getUser().id;
    this.pay.designation=this.login.getUser().designation;
    console.log(this.pay);
    this.payroll.generatePayroll(this.pay).subscribe((data: any)=>{
      //success
      console.log("success");
      this.snack.open("Employee Pay Slip Generate ",'',{
        duration:3000,
        
      })
    },
    (error:any)=>{
      //error
      this.snack.open("Get Updated Payslip by clicking on 'Update Payslip'",'',{
        duration:4000,
        
      })
    });
  }

  payrollUpdate(){
    console.log(this.paydata);
    this.payroll.updatePayroll(this.paydata.pay_id).subscribe();
    this.snack.open("Payslip Updated! Proceed to View Payslip",'',{
      duration:3000,
    });
  }
  
}
