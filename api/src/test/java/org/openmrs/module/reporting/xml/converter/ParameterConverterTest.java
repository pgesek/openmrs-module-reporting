package org.openmrs.module.reporting.xml.converter;

import org.junit.Assert;
import org.junit.Test;
import org.openmrs.module.reporting.evaluation.parameter.Parameter;
import org.openmrs.module.reporting.report.util.ReportUtil;
import org.openmrs.module.reporting.xml.XmlReportSerializer;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;

public class ParameterConverterTest extends BaseConverterTest {

    protected String getXml() {
        return ReportUtil.readStringFromResource("org/openmrs/module/reporting/xml/converter/parameter.xml");
    }

    @Test
    public void testMarshall() throws Exception {
        XmlReportSerializer serializer = getSerializer();
        Parameter p = serializer.fromXml(Parameter.class, getXml());
        Assert.assertThat(p.getName(), is("searchStrings"));
        Assert.assertTrue(p.getType() == String.class);
        Assert.assertTrue(p.getCollectionType() == List.class);
    }
}