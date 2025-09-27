/*
 * ***** BEGIN LICENSE BLOCK *****
 * Maldua Zimbra ActiveSync Extension
 * Copyright (C) 2025 BTACTIC, S.C.C.L.
 *
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software Foundation,
 * version 2 of the License.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License along with this program.
 * If not, see <http://www.gnu.org/licenses/>.
 * ***** END LICENSE BLOCK *****
 */
package com.btactic.activesync;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zimbra.common.util.ZimbraLog;

import com.zimbra.cs.extension.ExtensionHttpHandler;

/**
 *
 */
public class ZetaActiveSyncHandler extends ExtensionHttpHandler {

    /**
     * The path under which the handler is registered for an extension.
     * return "/mytest" makes it show up under:
     * https://testserver.example.com/service/extension/mytest
     *
     * @return path
     */
    @Override
    public String getPath() {
        // /opt/zimbra/jetty_base/jetty/etc/jetty.xml.in maps '/Microsoft-Server-ActiveSync/*' to '/service/extension/zimbrasync'.
        // Let's use /zimbrasync here to avoid having to rewrite nginx configuration files and jetty.xml.in
        return "/zimbrasync";
    }

    /**
     * Processes HTTP GET requests.
     *
     * @param req  request message
     * @param resp response message
     * @throws java.io.IOException
     * @throws javax.servlet.ServletException
     */
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        //Set the content type and charset for the response to the client.
        resp.setHeader("Content-Type", "text/html;charset=UTF-8");

        String html = """
            <html>
              <head><title>ZetaActiveSync</title></head>
              <body>
                You need to use an ActiveSync client instead of a browser.
                Learn more information at: <a href="https://github.com/maldua-suite/zimbra-maldua-activesync">Zimbra Maldua ActiveSync Github project page</a>.
              </body>
            </html>
            """;
        resp.getWriter().write(html);

        ZimbraLog.extensions.info("ZetaActiveSync has received a GET request.");

    }
}
