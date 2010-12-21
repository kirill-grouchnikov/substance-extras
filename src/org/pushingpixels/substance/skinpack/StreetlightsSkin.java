/*
 * Copyright (c) 2005-2010 Substance Kirill Grouchnikov. All Rights Reserved.
 *
 * Redistribution and use in source and binary forms, with or without 
 * modification, are permitted provided that the following conditions are met:
 * 
 *  o Redistributions of source code must retain the above copyright notice, 
 *    this list of conditions and the following disclaimer. 
 *     
 *  o Redistributions in binary form must reproduce the above copyright notice, 
 *    this list of conditions and the following disclaimer in the documentation 
 *    and/or other materials provided with the distribution. 
 *     
 *  o Neither the name of Substance Kirill Grouchnikov nor the names of 
 *    its contributors may be used to endorse or promote products derived 
 *    from this software without specific prior written permission. 
 *     
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" 
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, 
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR 
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR 
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, 
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, 
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; 
 * OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE 
 * OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, 
 * EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE. 
 */
package org.pushingpixels.substance.skinpack;

import java.awt.Color;

import org.pushingpixels.substance.api.*;
import org.pushingpixels.substance.api.colorscheme.*;
import org.pushingpixels.substance.api.painter.border.GlassBorderPainter;
import org.pushingpixels.substance.api.painter.decoration.ArcDecorationPainter;
import org.pushingpixels.substance.api.painter.fill.GlassFillPainter;
import org.pushingpixels.substance.api.painter.highlight.ClassicHighlightPainter;
import org.pushingpixels.substance.api.shaper.ClassicButtonShaper;
import org.pushingpixels.substance.internal.colorscheme.BlendBiColorScheme;
import org.pushingpixels.substance.watermarkpack.SubstanceMetalWallWatermark;

/**
 * <code>Streelights</code> skin. This class is part of officially supported
 * API.
 * 
 * @author Kirill Grouchnikov
 * @since version 5.0
 */
public class StreetlightsSkin extends SubstanceSkin {
	/**
	 * Display name for <code>this</code> skin.
	 */
	public static final String NAME = "Streetlights";

	/**
	 * Creates a new <code>Streetlights</code> skin.
	 */
	public StreetlightsSkin() {
		SubstanceColorScheme activeScheme = new SunsetColorScheme()
				.saturate(0.4);

		// dark green theme by shifting charcoal
		SubstanceColorScheme deepGreenScheme = new CharcoalColorScheme()
				.hueShift(0.35);
		// default theme is ebony blended with the dark green
		SubstanceColorScheme defaultScheme = new BlendBiColorScheme(
				new EbonyColorScheme(), deepGreenScheme, 0.85);
		// disabled theme is shaded dark green
		SubstanceColorScheme disabledScheme = deepGreenScheme.shade(0.4);

		// default scheme bundle
		SubstanceColorSchemeBundle defaultSchemeBundle = new SubstanceColorSchemeBundle(
				activeScheme, defaultScheme, disabledScheme);
		// use charcoal for borders on active states
		defaultSchemeBundle.registerColorScheme(new CharcoalColorScheme(),
				ColorSchemeAssociationKind.BORDER, ComponentState
						.getActiveStates());
		// and 60% alpha on disabled controls
		defaultSchemeBundle.registerColorScheme(disabledScheme, 0.6f,
				ComponentState.DISABLED_UNSELECTED,
				ComponentState.DISABLED_SELECTED);
		this.registerDecorationAreaSchemeBundle(defaultSchemeBundle,
				DecorationAreaType.NONE);

		// mark title panes and headers as decoration areas
		this.registerAsDecorationArea(defaultScheme,
				DecorationAreaType.PRIMARY_TITLE_PANE,
				DecorationAreaType.SECONDARY_TITLE_PANE,
				DecorationAreaType.HEADER);

		// set dark green as watermark scheme
		this.watermarkScheme = new BottleGreenColorScheme().shiftBackground(
				new Color(0, 50, 0), 0.7);
		this.setSelectedTabFadeStart(1.0);
		this.setSelectedTabFadeEnd(1.0);

		// additional skin settings
		this.buttonShaper = new ClassicButtonShaper();
		this.watermark = new SubstanceMetalWallWatermark();
		this.borderPainter = new GlassBorderPainter();
		this.highlightPainter = new ClassicHighlightPainter();
		this.fillPainter = new GlassFillPainter();
		this.decorationPainter = new ArcDecorationPainter();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.pushingpixels.substance.skin.SubstanceSkin#getDisplayName()
	 */
	public String getDisplayName() {
		return NAME;
	}
}
