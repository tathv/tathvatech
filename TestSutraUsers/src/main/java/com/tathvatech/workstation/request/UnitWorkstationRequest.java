package com.tathvatech.workstation.request;

import com.tathvatech.user.OID.ProjectOID;
import com.tathvatech.user.OID.WorkstationOID;
import lombok.Data;

@Data
public class UnitWorkstationRequest {
   private int unitPk;
   private ProjectOID projectOID;
  private  WorkstationOID workstationOID;
}