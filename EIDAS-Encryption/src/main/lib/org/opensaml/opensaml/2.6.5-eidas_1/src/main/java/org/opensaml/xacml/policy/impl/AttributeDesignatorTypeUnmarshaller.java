/*
 * Licensed to the University Corporation for Advanced Internet Development, 
 * Inc. (UCAID) under one or more contributor license agreements.  See the 
 * NOTICE file distributed with this work for additional information regarding
 * copyright ownership. The UCAID licenses this file to You under the Apache 
 * License, Version 2.0 (the "License"); you may not use this file except in 
 * compliance with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.opensaml.xacml.policy.impl;

import org.opensaml.xacml.impl.AbstractXACMLObjectUnmarshaller;
import org.opensaml.xacml.policy.AttributeDesignatorType;
import org.opensaml.xml.XMLObject;
import org.opensaml.xml.io.UnmarshallingException;
import org.opensaml.xml.schema.XSBooleanValue;
import org.opensaml.xml.util.DatatypeHelper;
import org.w3c.dom.Attr;

/**
 * Unmarshaller for {@link AttributeDesignatorType}.
 */
public class AttributeDesignatorTypeUnmarshaller extends AbstractXACMLObjectUnmarshaller {

    /** Constructor. */
    public AttributeDesignatorTypeUnmarshaller() {
        super();
    }
    
    /** {@inheritDoc} */
    protected void processAttribute(XMLObject xmlObject, Attr attribute) throws UnmarshallingException {
        
        AttributeDesignatorType attributeDesignatorType = (AttributeDesignatorType) xmlObject;
        
        if (attribute.getLocalName().equals(AttributeDesignatorType.ATTRIBUTE_ID_ATTRIB_NAME)){
            attributeDesignatorType.setAttribtueId(DatatypeHelper.safeTrimOrNullString(attribute.getValue()));
        } else  if (attribute.getLocalName().equals(AttributeDesignatorType.DATA_TYPE_ATTRIB_NAME)){
            attributeDesignatorType.setDataType(DatatypeHelper.safeTrimOrNullString(attribute.getValue()));
        } else  if (attribute.getLocalName().equals(AttributeDesignatorType.ISSUER_ATTRIB_NAME)){
            attributeDesignatorType.setIssuer(DatatypeHelper.safeTrimOrNullString(attribute.getValue()));
        } else  if (attribute.getLocalName().equals(AttributeDesignatorType.MUST_BE_PRESENT_ATTRIB_NAME)){
            if (attribute.getValue().equals("True") || attribute.getValue().equals("true")) {
                attributeDesignatorType.setMustBePresentXSBoolean(XSBooleanValue.valueOf("1"));
            } else {
                attributeDesignatorType.setMustBePresentXSBoolean(XSBooleanValue.valueOf("0"));
            }          
        } else {
            super.processAttribute(xmlObject, attribute);
        }
    }

}
