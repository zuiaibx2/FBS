/**
 * IWriteWSDataServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package nc.ui.export.webservice;

import nc.bs.framework.common.NCLocator;
import nc.ws.itf.ISendDataService;

public class IWriteWSDataServiceLocator extends org.apache.axis.client.Service
		implements nc.ui.export.webservice.IWriteWSDataService {

	public IWriteWSDataServiceLocator() {
	}

	public IWriteWSDataServiceLocator(org.apache.axis.EngineConfiguration config) {
		super(config);
	}

	public IWriteWSDataServiceLocator(java.lang.String wsdlLoc,
			javax.xml.namespace.QName sName)
			throws javax.xml.rpc.ServiceException {
		super(wsdlLoc, sName);
	}

	// Use to get a proxy class for IWriteWSDataServiceSOAP11port_http
	private java.lang.String IWriteWSDataServiceSOAP11port_http_address = "http://"
			+ getWebServicePort()
			+ "/uapws/service/nc.ws.itf.IWriteWSDataService";

	private String port = null;

	private String getWebServicePort() {
		if (port == null) {
			ISendDataService sendService = (ISendDataService) NCLocator
					.getInstance().lookup(ISendDataService.class.getName());
			port = sendService.getWebServicePort();
		}
		return port;
	}

	public java.lang.String getIWriteWSDataServiceSOAP11port_httpAddress() {
		return IWriteWSDataServiceSOAP11port_http_address;
	}

	// The WSDD service name defaults to the port name.
	private java.lang.String IWriteWSDataServiceSOAP11port_httpWSDDServiceName = "IWriteWSDataServiceSOAP11port_http";

	public java.lang.String getIWriteWSDataServiceSOAP11port_httpWSDDServiceName() {
		return IWriteWSDataServiceSOAP11port_httpWSDDServiceName;
	}

	public void setIWriteWSDataServiceSOAP11port_httpWSDDServiceName(
			java.lang.String name) {
		IWriteWSDataServiceSOAP11port_httpWSDDServiceName = name;
	}

	public nc.ui.export.webservice.IWriteWSDataServicePortType getIWriteWSDataServiceSOAP11port_http()
			throws javax.xml.rpc.ServiceException {
		java.net.URL endpoint;
		try {
			endpoint = new java.net.URL(
					IWriteWSDataServiceSOAP11port_http_address);
		} catch (java.net.MalformedURLException e) {
			throw new javax.xml.rpc.ServiceException(e);
		}
		return getIWriteWSDataServiceSOAP11port_http(endpoint);
	}

	public nc.ui.export.webservice.IWriteWSDataServicePortType getIWriteWSDataServiceSOAP11port_http(
			java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
		try {
			nc.ui.export.webservice.IWriteWSDataServiceSOAP11BindingStub _stub = new nc.ui.export.webservice.IWriteWSDataServiceSOAP11BindingStub(
					portAddress, this);
			_stub.setPortName(getIWriteWSDataServiceSOAP11port_httpWSDDServiceName());
			return _stub;
		} catch (org.apache.axis.AxisFault e) {
			return null;
		}
	}

	public void setIWriteWSDataServiceSOAP11port_httpEndpointAddress(
			java.lang.String address) {
		IWriteWSDataServiceSOAP11port_http_address = address;
	}

	/**
	 * For the given interface, get the stub implementation. If this service has
	 * no port for the given interface, then ServiceException is thrown.
	 */
	public java.rmi.Remote getPort(Class serviceEndpointInterface)
			throws javax.xml.rpc.ServiceException {
		try {
			if (nc.ui.export.webservice.IWriteWSDataServicePortType.class
					.isAssignableFrom(serviceEndpointInterface)) {
				nc.ui.export.webservice.IWriteWSDataServiceSOAP11BindingStub _stub = new nc.ui.export.webservice.IWriteWSDataServiceSOAP11BindingStub(
						new java.net.URL(
								IWriteWSDataServiceSOAP11port_http_address),
						this);
				_stub.setPortName(getIWriteWSDataServiceSOAP11port_httpWSDDServiceName());
				return _stub;
			}
		} catch (java.lang.Throwable t) {
			throw new javax.xml.rpc.ServiceException(t);
		}
		throw new javax.xml.rpc.ServiceException(
				"There is no stub implementation for the interface:  "
						+ (serviceEndpointInterface == null ? "null"
								: serviceEndpointInterface.getName()));
	}

	/**
	 * For the given interface, get the stub implementation. If this service has
	 * no port for the given interface, then ServiceException is thrown.
	 */
	public java.rmi.Remote getPort(javax.xml.namespace.QName portName,
			Class serviceEndpointInterface)
			throws javax.xml.rpc.ServiceException {
		if (portName == null) {
			return getPort(serviceEndpointInterface);
		}
		java.lang.String inputPortName = portName.getLocalPart();
		if ("IWriteWSDataServiceSOAP11port_http".equals(inputPortName)) {
			return getIWriteWSDataServiceSOAP11port_http();
		} else {
			java.rmi.Remote _stub = getPort(serviceEndpointInterface);
			((org.apache.axis.client.Stub) _stub).setPortName(portName);
			return _stub;
		}
	}

	public javax.xml.namespace.QName getServiceName() {
		return new javax.xml.namespace.QName(
				"http://itf.ws.nc/IWriteWSDataService", "IWriteWSDataService");
	}

	private java.util.HashSet ports = null;

	public java.util.Iterator getPorts() {
		if (ports == null) {
			ports = new java.util.HashSet();
			ports.add(new javax.xml.namespace.QName(
					"http://itf.ws.nc/IWriteWSDataService",
					"IWriteWSDataServiceSOAP11port_http"));
		}
		return ports.iterator();
	}

	/**
	 * Set the endpoint address for the specified port name.
	 */
	public void setEndpointAddress(java.lang.String portName,
			java.lang.String address) throws javax.xml.rpc.ServiceException {

		if ("IWriteWSDataServiceSOAP11port_http".equals(portName)) {
			setIWriteWSDataServiceSOAP11port_httpEndpointAddress(address);
		} else { // Unknown Port Name
			throw new javax.xml.rpc.ServiceException(
					" Cannot set Endpoint Address for Unknown Port" + portName);
		}
	}

	/**
	 * Set the endpoint address for the specified port name.
	 */
	public void setEndpointAddress(javax.xml.namespace.QName portName,
			java.lang.String address) throws javax.xml.rpc.ServiceException {
		setEndpointAddress(portName.getLocalPart(), address);
	}

}
