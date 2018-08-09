<%-- 
    Document   : Home
    Created on : Aug 5, 2018, 7:10:34 PM
    Author     : Vilim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <style>
        *{
            font-family:"Segoe UI";
        }
        td{
            padding:6px;
            border-left: 1px solid black;

        }
        td:nth-child(odd){
            font-weight: bold;
        }
        table{
            background-color: #f6f6f6;
            border-collapse: collapse;
            border:1px solid black;
        }


        tr:nth-child(odd){
            background: #e9e9e9;
        }
    </style>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Help</title>
    </head>
    <body>
        <h3>How to:</h3>
        <ol>
            <li>Create an account:
                <table>
                    <tbody>
                        <tr>
                            <td>HTTP method</td>
                            <td>POST</td>
                        </tr>
                        <tr>
                            <td>URI</td>
                            <td>/account</td>
                        </tr>
                        <tr>
                            <td>Request type</td>
                            <td>application/json</td>
                        </tr>
                        <tr>
                            <td>Request body</td>
                            <td>JSON body with 'accountId' parameter<br/>
                                <ul>
                                    <li>
                                        accountId (String, mandatory <br/>
                                        Example: { accountId : 'myAccountId'}
                                    </li>
                                </ul>
                            </td>
                        </tr>
                        <tr>
                            <td>Response type</td>
                            <td>application/json</td>
                        </tr>
                        <tr>
                            <td>Response</td>
                            <td> The response parameters are as follows
                                <ul>
                                    <li>success : true/false</li>
                                    <li>description : Description of status, for example: account with that
                                        ID already exists</li>
                                    <li>password: Returns only if the account was successfully created.</li>
                                </ul>

                                Example:
                                <br/>
                                {success: 'true', description: 'Your account is opened',
                                password: 'xC345Fc0'}


                            </td>
                        </tr>
                    </tbody>
                </table>
            </li>
            <li>
                Register a URL which you want shortened
                <br/>
                <table>
                    <tbody>
                        <tr>
                            <td>HTTP method</td>
                            <td>POST</td>
                        </tr>
                        <tr>
                            <td>URI</td>
                            <td>/register</td>
                        </tr>
                        <tr>
                            <td>Request type</td>
                            <td>application/json</td>
                        </tr>
                        <tr>
                            <td>Request header</td>
                            <td>Authorization header with Basic authentication token</td>
                        </tr>
                        <tr>
                            <td>Request body</td>
                            <td>JSON object with the following parameters: <br />
                                <ul>
                                    <li>url (String, mandatory</li>
                                    <li>redirectType : 301 | 302 (not mandatory, default 302)</li>
                                </ul>
                                <br/>
                                Example: {
                                url: 'http://myurl.com/myprofile',
                                redirectType : 301
                                }

                            </td>
                        </tr>
                        <tr>
                            <td>Response type</td>
                            <td>application/json</td>
                        </tr>
                        <tr>
                            <td>Response</td>
                            <td>Response parameters in case of successful registration are as follows:
                                <ul>
                                    <li>
                                        shortUrl (shortened URL)
                                    </li>
                                </ul>
                                <br/>
                                Example: { shortUrl: 'http://short.com/xYswlE'}</td>
                        </tr>
                    </tbody>
                </table>
            </li>
            <li>
                Retrieval of statistics
                <table>
                    <tbody>
                        <tr>
                            <td>HTTP method</td>
                            <td>GET</td>
                        </tr>
                        <tr>
                            <td>URI</td>
                            <td>/statistic/{accountId}</td>
                        </tr>
                        <tr>
                            <td>Request headers</td>
                            <td>Authorization header with Basic authentication token</td>
                        </tr>
                        <tr>
                            <td>Response type</td>
                            <td>application/json</td>
                        </tr>
                        <tr>
                            <td>Response</td>
                            <td>
                                The server responds with a JSON object, key:value map, where the key
                                is the registered URL, and the value is the number of this URL redirects..
                                <br/>
                                Example:
                                <br/>
                                {
                                'http://myweb.com/someverylongurl/thensomedirectory/: 10,<br/>
                                'http://myweb.com/someverylongurl2/thensomedirectory2/: 4,<br/>
                                'http://myweb.com/someverylongurl3/thensomedirectory3/: 91
                                }
                            </td>
                        </tr>
                    </tbody>
                </table>
            </li>
        </ol>
    </body>
</html>
