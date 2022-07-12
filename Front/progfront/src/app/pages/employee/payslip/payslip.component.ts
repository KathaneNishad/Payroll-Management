import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { LeaveserviceService } from 'src/app/services/leaveservice.service';
import { LoginService } from 'src/app/services/login.service';
import { PayrollService } from 'src/app/services/payroll.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-payslip',
  templateUrl: './payslip.component.html',
  styleUrls: ['./payslip.component.css']
})
export class PayslipComponent implements OnInit {
  
  payslip:any={
    "pay_id":"",
    "user_id":"",
    "designation":"",
    "basic":"",
    "leavesTaken":"",
    "deduction":""
  };
  
  basicSalary:number=0;
  da:number=0;
  hra:number=0;
  medical:number=0;
  travel:number=0;
  gross:number=0;
  net:number=0;

  numberOfLeave:number=0;
  deducePerLeave:number=0;
  totalDeduction:number=0;

  constructor(private userService:UserService,
    private snack:MatSnackBar,
    private leaveService:LeaveserviceService,
    public login:LoginService,
    private payroll:PayrollService) { }

  ngOnInit(): void {
  this.payroll.getPayrollByUserId(this.login.getUser().id).subscribe(data=>this.payslip=data);
  }
  
  //Salary
  getBasic(basic:number){
    return this.basicSalary=basic;
  }
  getDA(){
    return this.da=((this.basicSalary)*5)/100;
  }
  getHRA(){
    return this.hra=((this.basicSalary)*10)/100;
  }
  getTravel(){
    return this.travel=((this.basicSalary)*4)/100;
  }
  getMedical(){
    return this.medical=((this.basicSalary)*12)/100;
  }
  getGross(){
    return this.gross=Number(this.basicSalary)+Number(this.da)+Number(this.hra)+Number(this.travel)+Number(this.medical);
  }
  getNet(){
    return this.net=Number(this.gross) - Number(this.totalDeduction);
  }

  //Leave
  getLeaves(leaves:number){
    return this.numberOfLeave=leaves;
  }
  getDeducePerLeave(deduce:number){
    return this.deducePerLeave=deduce;
  }
  getDeduction(){
    return this.totalDeduction=this.deducePerLeave * this.numberOfLeave;
  }
  
}
