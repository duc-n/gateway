package com.coface.corp.autonomy.gateway.model;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@Data
@XmlRootElement(name="result")
@XmlAccessorType(XmlAccessType.FIELD)
public class ElanAcc {
    @XmlValue
    private String elanId;
}
