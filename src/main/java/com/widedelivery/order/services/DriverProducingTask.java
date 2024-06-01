package com.widedelivery.order.services;

import com.google.protobuf.Timestamp;
import com.widedelivery.order.models.DriverDto;
import com.widedelivery.order.models.DriverTripDto;
import com.widedelivery.order.models.DriverTripStatus;
import com.widedelivery.utils.GeoLocationUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.System.out;
import static java.lang.Thread.currentThread;
import static java.util.concurrent.TimeUnit.SECONDS;

@Component
public class DriverProducingTask implements Runnable {
    private static final String MESSAGE_OF_DRIVER_IS_PRODUCED = "[PRODUCED DRIVER] %s.\n";
    private static final int SECONDS_DURATION_TO_SLEEP_BEFORE_PRODUCING = 5;

    private final OrderMatchingProcessor orderMatchingProcessor;
    private final DriverProducingTask.DriverFactory driverFactory;

    public DriverProducingTask(OrderMatchingProcessor orderMatchingProcessor) {
        this.orderMatchingProcessor = orderMatchingProcessor;
        this.driverFactory = new DriverProducingTask.DriverFactory();
    }

    @Override
    public void run() {
        try {
            while (!currentThread().isInterrupted()) {
                final DriverDto producedDriver = this.driverFactory.create();
                SECONDS.sleep(SECONDS_DURATION_TO_SLEEP_BEFORE_PRODUCING);
                this.orderMatchingProcessor.addDriverForMatching(producedDriver);
                out.printf(MESSAGE_OF_DRIVER_IS_PRODUCED, producedDriver);
            }
        } catch (final InterruptedException interruptedException) {
            currentThread().interrupt();
        }

    }

    private static final class DriverFactory {
        private static final int INITIAL_DRIVER_INDEX = 1;

        private int nextDriverIndex;

        public DriverFactory() {
            this.nextDriverIndex = INITIAL_DRIVER_INDEX;
        }

        public DriverDto create() {
            return new DriverDto(
                    String.format("driver-%d", nextDriverIndex++),
                    true,
                    15,
                    new DriverDto.TruckDto(
                            new Random().nextDouble(),
                            new Random().nextDouble(),
                            new Random().nextDouble(),
                            true
                    ),
                    new ArrayList<>(List.of(
                            new DriverTripDto(
                                    String.format("trip-%d-%d", nextDriverIndex - 1, 1),
                                    String.format("driver-%d", nextDriverIndex - 1),
                                    String.format("%.7f", GeoLocationUtils.generateRandomGeoLocationPoint().getLatitude()),
                                    String.format("%.7f", GeoLocationUtils.generateRandomGeoLocationPoint().getLongitude()),
                                    Timestamp.getDefaultInstance(),
                                    String.format("%.7f", GeoLocationUtils.generateRandomGeoLocationPoint().getLatitude()),
                                    String.format("%.7f", GeoLocationUtils.generateRandomGeoLocationPoint().getLongitude()),
                                    Timestamp.getDefaultInstance(),
                                    (Math.random() * 100 + 1),
                                    (Math.random() * 75 + 1),
                                    (Math.random() * 20 + 1),
                                    DriverTripStatus.EXPECTED,
                                    new ArrayList<>()
                            ),
                            new DriverTripDto(
                                    String.format("trip-%d-%d", nextDriverIndex - 1, 2),
                                    String.format("driver-%d", nextDriverIndex - 1),
                                    String.format("%.7f", GeoLocationUtils.generateRandomGeoLocationPoint().getLatitude()),
                                    String.format("%.7f", GeoLocationUtils.generateRandomGeoLocationPoint().getLongitude()),
                                    Timestamp.getDefaultInstance(),
                                    String.format("%.7f", GeoLocationUtils.generateRandomGeoLocationPoint().getLatitude()),
                                    String.format("%.7f", GeoLocationUtils.generateRandomGeoLocationPoint().getLongitude()),
                                    Timestamp.getDefaultInstance(),
                                    (Math.random() * 100 + 1),
                                    (Math.random() * 75 + 1),
                                    (Math.random() * 20 + 1),
                                    DriverTripStatus.EXPECTED,
                                    new ArrayList<>()
                            )
                    ))
            );
        }
    }

}
