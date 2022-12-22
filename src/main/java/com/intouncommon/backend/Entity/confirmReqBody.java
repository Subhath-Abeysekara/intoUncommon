package com.intouncommon.backend.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class confirmReqBody {

    List<Long> catIds;
}
