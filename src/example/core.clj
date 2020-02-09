(ns example.core
  (:import boofcv.alg.color.ColorRgb
           boofcv.core.image.ConvertImage
           boofcv.gui.ListDisplayPanel
           boofcv.gui.image.ShowImages
           boofcv.io.UtilIO
           boofcv.io.image.ConvertBufferedImage
           boofcv.io.image.UtilImageIO
           boofcv.struct.image.GrayU8
           boofcv.struct.image.ImageType
           boofcv.struct.image.Planar
           java.awt.image.BufferedImage
           ))
(let [image-url  "https://geokon-gh.github.io/web/chengdu.jpg"
      color (ConvertBufferedImage/convertFrom (UtilImageIO/loadImage image-url)
                                              true,
                                              (ImageType/pl 3 GrayU8))
      weighted (GrayU8. (.width color)
                       (.height color))
      gui (ListDisplayPanel.)]
  (ColorRgb/rgbToGray_Weighted color weighted)
  (.addImage gui
             weighted
             (str (.width color)
                  " "
                  (.height color)))
  (ShowImages/showWindow gui
                         "RGB222"
                         true))
